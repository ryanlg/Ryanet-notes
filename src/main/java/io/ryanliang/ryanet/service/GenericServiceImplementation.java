package io.ryanliang.ryanet.service;

import io.ryanliang.ryanet.dao.GenericDaoInterface;
import org.springframework.stereotype.Service;

@Service
public abstract class GenericServiceImplementation<PersistentClass, DaoClass extends
        GenericDaoInterface<PersistentClass>>
        implements GenericServiceInterface<PersistentClass> {

    protected DaoClass genericDao;

    /*
    private BeanFactory beanFactory;

    @Autowired
    @SuppressWarnings("unchecked")
    public GenericServiceImplementation(BeanFactory beanFactory){

        this.beanFactory = beanFactory;

        @SuppressWarnings("ConstantConditions")
        Class<?> concrete =
                GenericTypeResolver.resolveTypeArguments(getClass(),
                                                         GenericServiceImplementation.class)[0];
        this.genericDao = (DaoClass) beanFactory.getBean(concrete);
    }*/

    public PersistentClass save(PersistentClass entity) {

         genericDao.persist(entity);
         return entity;
    }

    @Override
    public PersistentClass delete(PersistentClass entity) {

        genericDao.delete(entity);
        return entity;
    }
}
