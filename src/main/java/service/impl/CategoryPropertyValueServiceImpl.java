package service.impl;

import com/dianwoyin/price/model.CategoryPropertyValue;
import com/dianwoyin/price/mapper.CategoryPropertyValueMapper;
import service.ICategoryPropertyValueService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 类目属性值定义表 服务实现类
 * </p>
 *
 * @author dongchunxu
 * @since 2021-06-18
 */
@Service
public class CategoryPropertyValueServiceImpl extends ServiceImpl<CategoryPropertyValueMapper, CategoryPropertyValue> implements ICategoryPropertyValueService {

}
