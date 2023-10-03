package ru.evgen.springsource.firstsecurityapp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.evgen.springsource.firstsecurityapp.models.Person;

import java.util.Collection;

public class PersonDetails implements UserDetails {
    private final Person person;

    public PersonDetails(Person person) {
        this.person = person;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() { // Метод авторизации пользователя (список его прав)
        return null;
    }

    @Override
    public String getPassword() { // Получение пароля Person
        return this.person.getPassword();
    }

    @Override
    public String getUsername() { // Получение логина Person
        return this.person.getName();
    }

    @Override
    public boolean isAccountNonExpired() { // Проверяет не просрочен ли аккаунт
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {  // Проверяет не заблокирован ли аккаунт
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {  // Проверяет не просрочен ли пароль
        return true;
    }

    @Override
    public boolean isEnabled() { // Проверяет работает ли аккаунт
        return false;
    }
    // Нужен чтобы получать данные идентифицированного пользователя
    public Person getPerson(){
        return this.person;
    }
}
