package ch02.domain;

import java.math.BigDecimal;

/**
 * 1장에서는 금액을 구현하기 위해 Long 타입을 사용했다. Long 타입은 변수 크기나 연산자 종류와 관련된 구현 관점의 제약은 표현할 수 있지만
 * Money 타입처럼 저장하는 값이 금액과 관련돼 있다는 의미는 전달할 수 없다. 또한 금액 관련 로직이 서로 다른 곳에 중복 구현되는 것을 막을 수 없다.
 * 객체지향의 장점은 객체를 이용해 도메인 의미를 풍부하게 표현할 수 있다는 것이다.
 * 따라서 의미를 더 명시적이고 뿐명하게 표현할 수 있다면 객체를 사용해서 해당 개념을 구현하면 좋다.
 * 그 개념이 비록 하나의 인스턴스 변수만을 포함하더라도 개념을 명시적으로 표현하는 것은 전체적인 설계의 명확성과 유연성을 높인다.
 */
public class Money {
    public static final Money ZERO = Money.wons(0);

    private final BigDecimal amount;

    public static Money wons(long amount) {
        return new Money(BigDecimal.valueOf(amount));
    }

    public static Money wons(double amount) {
        return new Money(BigDecimal.valueOf(amount));
    }

    Money(BigDecimal amount) {
        this.amount = amount;
    }

    public Money plus(Money amount) {
        return new Money(this.amount.add(amount.amount));
    }

    public Money minus(Money amount) {
        return new Money(this.amount.subtract(amount.amount));
    }

    public Money times(double percent) {
        return new Money(this.amount.multiply(BigDecimal.valueOf(percent)));
    }

    public boolean isLessThan(Money other) {
        return amount.compareTo(other.amount) < 0;
    }

    public boolean isGreaterThanOrEquals(Money other) {
        return amount.compareTo(other.amount) >= 0;
    }
}
