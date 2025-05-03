package ignite.api.security.service;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import ignite.api.models.enums.SocialType;

public class CustomUserDetails implements UserDetails {

    private Long id;
    private String name;
    private String email;

    @JsonIgnore
    private String password;
    @JsonIgnore
    private SocialType socialType;
    @JsonIgnore
    private String phone;

    private Collection<? extends GrantedAuthority> authorities;

    public CustomUserDetails(Long id, String name, String email, String password, SocialType socialType, String phone,
            Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.socialType = socialType;
        this.phone = phone;
        this.authorities = authorities;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public String getPhone() {
        return phone;
    }

    public String getName() {
        return name;
    }

}
