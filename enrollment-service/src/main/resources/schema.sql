DROP TABLE IF EXISTS t_user_enroll;
DROP TABLE IF EXISTS t_user_dep;

CREATE TABLE t_user_enroll(
enroll_id NUMBER PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(20) NOT NULL,
act_status VARCHAR(20) NOT NULL,
dob DATE NOT NULL,
phone_num VARCHAR(32)
);
	
CREATE TABLE t_user_dep(
  dep_id NUMBER PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(20) NOT NULL,    
  dob DATE NOT NULL,
  enroll_id NUMBER,
  foreign key (enroll_id) references t_user_enroll
);