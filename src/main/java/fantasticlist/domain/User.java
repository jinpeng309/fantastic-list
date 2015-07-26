package fantasticlist.domain;

import java.sql.Date;
import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor(staticName="of")
@AllArgsConstructor
public class User {
	Long   uid;
	@NonNull
	String username;
	@NonNull
	String password;
	Timestamp lastlogin;
	Timestamp lastlogout;
	Timestamp createtime;
	String email;
	String phone;
}
