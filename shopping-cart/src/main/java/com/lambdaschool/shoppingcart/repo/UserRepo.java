package com.lambdaschool.shoppingcart.repo;


        import com.lambdaschool.shoppingcart.models.User;
        import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long>
{

    User findByUsername(String username);
}