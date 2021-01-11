package com.assignments.assignment7.Security;


public class AuthenticationResponse {

		private final String JWT;
		
		public AuthenticationResponse (String JWT) {
				this.JWT =JWT;
		}
		
		public String getJWT() {
			return JWT;
		}
	}

