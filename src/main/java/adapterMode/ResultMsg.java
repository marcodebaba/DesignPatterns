package adapterMode;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author：marco.pan
 * @ClassName：ResultMsg
 * @Description：
 * @date: 2026年02月09日 9:27
 */
@Data
@AllArgsConstructor
public class ResultMsg {
    private int code;
    private String msg;
    private Object data;
}
