package club.gclmit.gpi.logger.service.impl;

import club.gclmit.gpi.logger.mapper.LoggerMapper;
import club.gclmit.gpi.logger.service.LoggerService;
import club.gclmit.gpi.logger.pojo.HttpTrace;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  日志服务接口
 * </p>
 *
 * @author 孤城落寞
 * @since 2019-12-17
 */
@Service
public class LoggerServiceImpl extends ServiceImpl<LoggerMapper, HttpTrace> implements LoggerService {


}
