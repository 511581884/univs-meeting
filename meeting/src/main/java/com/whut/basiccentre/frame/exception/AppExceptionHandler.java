package com.whut.basiccentre.frame.exception;

import com.whut.basiccentre.frame.bean.ResponseBean;
import com.whut.basiccentre.frame.bean.ResponseType;
import com.whut.basiccentre.frame.utils.ExceptionUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.validation.UnexpectedTypeException;
import java.sql.SQLException;
import java.util.List;

@Slf4j
@ResponseBody
@ControllerAdvice("com.whut.basiccentre")
public class AppExceptionHandler {


    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(UnexpectedTypeException.class)
    public ResponseBean unexpectedType(UnexpectedTypeException exception) {
        log.error("校验方法太多，不确定合适的校验方法。{}", ExceptionUtils.collectExceptionStackMsg(exception));
        return ResponseType.SERVICE_ERROR.getResponseBean();
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({MethodArgumentNotValidException.class, BindException.class})
    public ResponseBean paramExceptionHandler(MethodArgumentNotValidException exception) {
        BindingResult exceptions = exception.getBindingResult();
        // 判断异常中是否有错误信息，如果存在就使用异常中的消息，否则使用默认消息
        if (exceptions.hasErrors()) {
            List<ObjectError> errors = exceptions.getAllErrors();
            if (!errors.isEmpty()) {
                // 这里列出了全部错误参数，按正常逻辑，只需要第一条错误即可
                FieldError fieldError = (FieldError) errors.get(0);
                return  ResponseBean.error(fieldError.getDefaultMessage()) ;
            }
        }
        return ResponseBean.error("请求参数错误");
    }

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseBean messageNotReadable(HttpMessageNotReadableException exception) {
        log.error("请求参数不匹配。{}", ExceptionUtils.collectExceptionStackMsg(exception));
        return ResponseType.SERVICE_ERROR.getResponseBean();
    }

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseBean dataIntegrityViolationException(DataIntegrityViolationException exception) {
        log.error("新增或更新sql异常: {}", ExceptionUtils.collectExceptionStackMsg(exception));
        return ResponseBean.error(exception.getMessage());
//        return ResponseType.SERVICE_ERROR.getResponseBean();
    }

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(value = AppException.class)
    public ResponseBean handleCmsException(AppException exception) {
        log.error("自定义错误: {}", ExceptionUtils.collectExceptionStackMsg(exception));
        return ResponseBean.error(exception.getCode(), exception.getMessage());
    }

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseBean handleNoHandlerFoundException(NoHandlerFoundException exception) {
        log.error("没找到请求:{}", ExceptionUtils.collectExceptionStackMsg(exception));
        return ResponseType.SERVICE_ERROR.getResponseBean();
    }

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(Exception.class)
    public ResponseBean handleException(Exception exception) {
        log.error("其他异常: {}", ExceptionUtils.collectExceptionStackMsg(exception));
        return ResponseType.SERVICE_ERROR.getResponseBean();
    }

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(SQLException.class)
    public ResponseBean handleSQLException(SQLException exception) {
        log.error("sql异常:{}", ExceptionUtils.collectExceptionStackMsg(exception));
        return ResponseType.SERVICE_ERROR.getResponseBean();
    }

}
