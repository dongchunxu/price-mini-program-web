package service.impl;

import com/dianwoyin/price/model.Account;
import com/dianwoyin/price/mapper.AccountMapper;
import service.IAccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 账户表 服务实现类
 * </p>
 *
 * @author dongchunxu
 * @since 2021-06-18
 */
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements IAccountService {

}
