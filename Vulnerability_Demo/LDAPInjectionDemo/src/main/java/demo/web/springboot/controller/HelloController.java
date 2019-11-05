package demo.web.springboot.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import javax.naming.NamingEnumeration;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.InitialLdapContext;

import java.net.URLEncoder;
import java.util.Hashtable;

@Controller
public class HelloController {

	@RequestMapping(value={"/LoginController"})
	public String index(@RequestParam String username,@RequestParam String  password) {
		String query = String.format("(&(uid=%s)(userPassword=%s))", username, password);
		Hashtable<String, Object> env = new Hashtable<>();
		env.put("java.naming.provider.url", "ldap://localhost:9999/dc=example,dc=org");
		env.put("java.naming.factory.initial", "com.sun.jndi.ldap.LdapCtxFactory");


		try {
			InitialLdapContext ctx = new InitialLdapContext(env, null);
			SearchControls constraints = new SearchControls();
			constraints.setSearchScope(SearchControls.SUBTREE_SCOPE);
			constraints.setReturningAttributes(new String[0]);      //return no attrs
			NamingEnumeration<SearchResult> results = ctx.search("", query, constraints);
			if (results.hasMore()) {
				results.close();
				return "redirect:/pages/success.html"+"?command=" + URLEncoder.encode(query);
			} else {
				results.close();
				return "redirect:/pages/error.html"+"?command=" + URLEncoder.encode(query);
			}



		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;


	}


	static String sanitize (String text){
		return text.replace("&", "&amp;").replace("'", "&apos;");
	}
}
