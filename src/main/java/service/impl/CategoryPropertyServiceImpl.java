package service.impl;

import com/dianwoyin/price/model.CategoryProperty;
import com/dianwoyin/price/mapper.CategoryPropertyMapper;
import service.ICategoryPropertyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 类目属性定义表 服务实现类
 * </p>
 *
 * @author dongchunxu
 * @since 2021-06-18
 */
@Service
public class CategoryPropertyServiceImpl extends ServiceImpl<CategoryPropertyMapper, CategoryProperty> implements ICategoryPropertyService {

}
