// package com.example.coffee_shop_managementSystem.config;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.web.SecurityFilterChain;

// @Configuration
// public class SecurityConfig {

//     @Bean
//     public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//         http
//             .authorizeHttpRequests(authorize -> authorize
//                 .requestMatchers("/admin").permitAll() // اسمح بالوصول إلى /admin دون تسجيل دخول
//                 .anyRequest().authenticated() // جميع المسارات الأخرى تتطلب تسجيل دخول
//             )
//             .formLogin(form -> form
//                 .loginPage("/login") // صفحة تسجيل الدخول المخصصة (إذا لزم الأمر)
//                 .permitAll()
//             )
//             .logout(logout -> logout
//                 .permitAll()
//             );
//         return http.build();
//     }
// }
