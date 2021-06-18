package service.impl;

import com/dianwoyin/price/model.TagDict;
import com/dianwoyin/price/mapper.TagDictMapper;
import service.ITagDictService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 标签定义表 服务实现类
 * </p>
 *
 * @author dongchunxu
 * @since 2021-06-18
 */
@Service
public class TagDictServiceImpl extends ServiceImpl<TagDictMapper, TagDict> implements ITagDictService {

}
