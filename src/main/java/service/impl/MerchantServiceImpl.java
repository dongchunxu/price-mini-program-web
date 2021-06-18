package service.impl;

import com/dianwoyin/price/model.Merchant;
import com/dianwoyin/price/mapper.MerchantMapper;
import service.IMerchantService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商户信息表 服务实现类
 * </p>
 *
 * @author dongchunxu
 * @since 2021-06-18
 */
@Service
public class MerchantServiceImpl extends ServiceImpl<MerchantMapper, Merchant> implements IMerchantService {

}
