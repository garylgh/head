/*
 * Copyright (c) 2005-2011 Grameen Foundation USA
 * All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied. See the License for the specific language governing
 * permissions and limitations under the License.
 *
 * See also http://www.apache.org/licenses/LICENSE-2.0.html for an
 * explanation of the license and how it is applied.
 */

package org.mifos.accounts.savings.interest;

import org.mifos.framework.util.helpers.Money;
import org.mifos.framework.util.helpers.MoneyUtils;

public class SimpleInterestCalculationStrategy {

    private final Double interestRate;
    private final int accountingNumberOfInterestDaysInYear;

    public SimpleInterestCalculationStrategy(Double interestRate, int numberOfDaysInYear) {
        this.interestRate = interestRate;
        this.accountingNumberOfInterestDaysInYear = numberOfDaysInYear;
    }

    public Money calculateInterest(Money principal, int duration) {

        Double effectiveInterestRate = (interestRate / accountingNumberOfInterestDaysInYear) * duration;

        Money interestAmount = principal.multiply(effectiveInterestRate / 100);

        return MoneyUtils.currencyRound(interestAmount);
    }
}