package it.beije.neumann.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*
CREATE TABLE authority (
  id int(11) NOT NULL,
  authority varchar(45) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB

CREATE TABLE user_authority (
  user_id int(11) NOT NULL,
  authority_id int(11) NOT NULL,
  PRIMARY KEY (user_id,authority_id),
  KEY fk_user_has_authority_authority1_idx (authority_id),
  KEY fk_user_has_authority_user1_idx (user_id),
  CONSTRAINT fk_user_has_authority_authority1 FOREIGN KEY (authority_id) REFERENCES authority (id),
  CONSTRAINT fk_user_has_authority_user1 FOREIGN KEY (user_id) REFERENCES users (id)
) ENGINE=InnoDB

INSERT INTO authority (id, authority) VALUES ('1', 'USER');
INSERT INTO authority (id, authority) VALUES ('2', 'ADMIN');
*/


@Entity
@Table(name = "authority")
public class Authority {
	
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

	@Column(name = "authority")
	private String authority;

	public String getAuthority() {
		return authority;
	}

}
