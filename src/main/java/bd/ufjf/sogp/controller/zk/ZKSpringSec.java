package bd.ufjf.sogp.controller.zk;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 *
 * @author Luis Augusto
 */
public class ZKSpringSec
{
    private static Collection<? extends GrantedAuthority> getUserAuthorities() 
    {
        return SecurityContextHolder.getContext().getAuthentication().getAuthorities();
    }

    private static Collection<GrantedAuthority> parseAuthoritiesString(String authorizationsString) 
    {
        Collection<GrantedAuthority> requiredAuthorities = new ArrayList<>();
        String[] roleList = authorizationsString.split(",");

        for (String role : roleList)
        {
            String roleTrim = role.trim();
            requiredAuthorities.add(new SimpleGrantedAuthority(roleTrim));
        }

        return requiredAuthorities;
    }

    private static Set authoritiesToRoles(Collection c) 
    {
        final Set target = new HashSet();
        
        for (Iterator iterator = c.iterator(); iterator.hasNext();) 
        {
            GrantedAuthority authority = (GrantedAuthority) iterator.next();

            if (null == authority.getAuthority()) 
            {
                throw new IllegalArgumentException(
                        "Cannot process GrantedAuthority objects which return null from getAuthority() - attempting to process "
                        + authority.toString());
            }

            target.add(authority.getAuthority());
        }
        
        return target;
    }
    
     private static Set rolesToAuthorities(Set grantedRoles, Collection granted) 
     {
        Set target = new HashSet();

        for (Iterator iterator = grantedRoles.iterator(); iterator.hasNext();) 
        {
            String role = (String) iterator.next();

            for (Iterator grantedIterator = granted.iterator(); grantedIterator.hasNext();) 
            {
                GrantedAuthority authority = (GrantedAuthority) grantedIterator.next();

                if (authority.getAuthority().equals(role)) 
                {
                    target.add(authority);
                    break;
                }
            }
        }

        return target;
    }
    
    private static Set retainAll(Collection<? extends GrantedAuthority> granted, Collection<GrantedAuthority> required)
    {
        Set grantedRoles = authoritiesToRoles(granted);
        Set requiredRoles = authoritiesToRoles(required);
        grantedRoles.retainAll(requiredRoles);

        return rolesToAuthorities(grantedRoles, granted);
    }
    

    public static boolean isAllGranted(String authorities) 
    {
        if (null == authorities || "".equals(authorities)) 
        {
            return false;
        }

        Collection<? extends GrantedAuthority> grantedRoleList = getUserAuthorities();
        
        return grantedRoleList.containsAll(parseAuthoritiesString(authorities));
    }

    public static boolean isNoneGranted(String authorities) 
    {
        if (null == authorities || "".equals(authorities)) 
        {
            return false;
        }

        Collection<? extends GrantedAuthority> grantedRoleList = getUserAuthorities();
        Set grantedCopy = retainAll(grantedRoleList, parseAuthoritiesString(authorities));
        
        return grantedCopy.isEmpty();
    }
    
    public static boolean isAnyGranted(String authorities)
    {
        if (null == authorities || "".equals(authorities))
        {
            return false;
        }
        
        Collection<? extends GrantedAuthority> grantedRoleList = getUserAuthorities();
        Set grantedCopy = retainAll(grantedRoleList, parseAuthoritiesString(authorities));
        
        return !grantedCopy.isEmpty();
    }
}
