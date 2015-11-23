package me.leizhnxp.examples.hessian.poc;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Account implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 4942820749468651250L;
	
	private String name;

}
