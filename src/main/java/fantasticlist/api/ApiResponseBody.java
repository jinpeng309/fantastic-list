package fantasticlist.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
public class ApiResponseBody {
	private static final long serialVersionUID = -2454950452642169245L;

	private String code;
	private String msg;
	private Object data;


	public static ApiResponseBody create(String code, String error, Object data) {
		return new ApiResponseBody(code, error, data);
	}

	public static ApiResponseBody createErrorBody(String code, String error) {
		return new ApiResponseBody(code, error, null);
	}

	public static ApiResponseBody createSuccessBody(Object data) {
		return new ApiResponseBody(ApiCode.SUCCESS, null, data);
	}

}
