package club.gclmit.gpi.core.exception;


import club.gclmit.gpi.web.response.Result;
import com.google.zxing.NotFoundException;
import com.google.zxing.WriterException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *    统一异常处理控制器
 * </p>
 * @author: 孤城落寞
 * @see: 2019-08-16 15:24
 * @see: com.petkit.profession.controller.GlobalDefaultExceptionHandlerController
 */
@RestController
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     *  处理 validate 异常
     * @author gclm
     * @param: exception
     * @date 2020/1/15 4:03 下午
     * @return: club.gclmit.chaos.web.response.Result
     * @throws
     */
    @ExceptionHandler(value = {
            BindException.class,
            MethodArgumentNotValidException.class
    })
    public Result validationExceptionHandler(Exception exception) {

        BindingResult bindResult = null;
        if (exception instanceof BindException) {
            bindResult = ((BindException) exception).getBindingResult();
        } else if (exception instanceof MethodArgumentNotValidException) {
            bindResult = ((MethodArgumentNotValidException) exception).getBindingResult();
        }
        StringBuilder message = new StringBuilder();

        if (bindResult != null && bindResult.hasErrors()) {
            bindResult.getAllErrors().forEach(objectError -> {
                message.append(objectError.getDefaultMessage()).append(",");
            });
        }else {
            message.append("系统繁忙，请稍后重试...");
        }
        return Result.fail(message.substring(0,message.length() - 1));
    }

    /**
     * 处理二维码相关异常
     * @author gclm
     * @param: exception
     * @date 2020/1/15 4:03 下午
     * @return: club.gclmit.chaos.web.response.Result
     * @throws
     */
    @ExceptionHandler(value = {
            NotFoundException.class,
            WriterException.class
    })
    public Result codeException(Exception exception) {

        String message = null;
        if(exception instanceof NotFoundException){
            message = "该图片不是二维码图片";
        }

        if(exception instanceof WriterException){
            message = "二维码图片合成失败，请稍后再试";
        }
        return Result.fail(message);
    }

    /**
     *  chaos组件相关的异常
     *
     * @author gclm
     * @param: exception
     * @date 2020/1/15 4:12 下午
     * @return: club.gclmit.chaos.web.response.Result
     * @throws
     */
    @ExceptionHandler(value = {
            AbstractChaosException.class,
            ChaosStorageException.class,
            ChaosSecurityException.class,
            ChaosLoggerException.class,
            ChaosWebException.class
    })
    public Result chaosException(Exception exception) {
        return Result.fail(exception.getMessage());
    }


}
