package service.impl;

import com/dianwoyin/price/model.Activity;
import com/dianwoyin/price/mapper.ActivityMapper;
import service.IActivityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 活动表 服务实现类
 * </p>
 *
 * @author dongchunxu
 * @since 2021-06-18
 */
@Service
public class ActivityServiceImpl extends ServiceImpl<ActivityMapper, Activity> implements IActivityService {

}
