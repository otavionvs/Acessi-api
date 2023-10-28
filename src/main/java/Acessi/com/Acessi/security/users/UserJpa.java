package Acessi.com.Acessi.security.users;

import Acessi.com.Acessi.model.entity.User;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
public class UserJpa implements UserDetails {

    private User user;
    public Collection<GrantedAuthority> authorities;

    private boolean accountNonExpired = true;

    private boolean accountNonLocked = true;

    private boolean credentialsNonExpired = true;

    private boolean enabled = true;

    public UserJpa(User user){
        this.user = user;
    }

    @Override
    public String getPassword() {
        return user.getPasswordUser();
    }

    @Override
    public String getUsername() {
        return user.getEmailUser();
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities(){
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(
                this.getUser().getAccessLevelUser().toString()
        ));
        return authorities;
    }
}
