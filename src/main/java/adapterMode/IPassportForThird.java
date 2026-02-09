package adapterMode;

/**
 * 统一的对外接口，客户端只需调用
 */
public interface IPassportForThird {
    ResultMsg registerByThird(String id, String channel);
}
