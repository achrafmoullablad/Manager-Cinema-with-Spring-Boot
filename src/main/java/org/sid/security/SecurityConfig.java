package org.sid.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig  extends WebSecurityConfigurerAdapter{
  
	
	//methode pour specifier les users de la bd
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		//creation de l bjet 
		PasswordEncoder passwordEncoser= passwordEncoder();

		//utiliser les users de memoirs et ajouter seules peut accder a l app
	
		auth.inMemoryAuthentication().withUser("user1").password(passwordEncoser.encode("1234")).roles("USER");
		auth.inMemoryAuthentication().withUser("user2").password(passwordEncoser.encode("1234")).roles("USER");
		//auth.inMemoryAuthentication().withUser("user3").password("{noop}1234").roles("USER");
		auth.inMemoryAuthentication().withUser("admin").password(passwordEncoser.encode("1234")).roles("USER","ADMIN");
	}
	
	
	

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//form de autification  et specifier votre propre form .loginPage("/login")
		//pour utliser auth basic utilise .httpbasic(); session sans form
		//utliser form de utu

		//http.httpBasic();
		http.formLogin().loginPage("/login");
		
//tous les requetq de sites demande authontification 
		//tous les requetes commence ou setremine par save seulemntles admins peut faire 
		http.formLogin().loginPage("/login");
http.authorizeRequests().antMatchers("/admin/**","save**/**","/form**/**","edit**/**").hasRole("ADMIN");
http.authorizeRequests().antMatchers("villes**/**,films**/**,cinemas**/**,salles**/**").hasRole("USER");
   //tous les autres requetes doit passe avec authifcation

//http.csrf();

//autorise sans authentification

//si il ya pas le droit d accede il faut aller au page de contoleur NotAutorized
http.exceptionHandling().accessDeniedPage("/403");
//desactiver ce mecanasime
//http.csrf().disable();
	}
	
	//cette l objet de app pour enjecter dans tous les parties de l app
@Bean
	public PasswordEncoder passwordEncoder(){
		//utiliser le
		return new BCryptPasswordEncoder();	
		

}}
