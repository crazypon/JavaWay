package JavaTesting;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

/*
Dependency Injection using JUnit library
 */
public class BankAccountParameterResolver implements ParameterResolver {

    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        // this portion of code tells that DI will work with only with BankAccount class
        return parameterContext.getParameter().getType() == BankAccount.class;
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        // when using DI, this method will create a new bank account like here, meaning each test will have
        // its own copy
        return new BankAccount(0, 0);
    }
}
