package ch02.domain;

import java.time.LocalDateTime;

/**
 * Screening 클래스는 사용자들이 예매하는 대상인 '상영'을 구현함.
 * Screening은 상영할 영화, 순번, 상영 시작 시간을 인스턴스 변수로 포함한다.
 * Screnning은 상영 시작 시간을 반환하는 getStartTime 메서드, 순번의 일치 여부를 검사하는 isSequence 메서드,
 * 기본 요금을 반환하는 getMovieFee 메서드를 포함한다.
 */
public class Screening {
    private Movie movie;
    private int sequence;
    private LocalDateTime whenScreened;

    public Screening(Movie movie, int sequence, LocalDateTime whenScreened) {
        this.movie = movie;
        this.sequence = sequence;
        this.whenScreened = whenScreened;
    }

    /**
     * calculateFee를 호출해서 요금을 게산한 후 그 결과를 Reservation 생성자에 전달한다.
     */
    public Reservation reserve(Customer customer, int audienceCount) {
        return new Reservation(customer, this, calculateFee(audienceCount), audienceCount);
    }

    public LocalDateTime getStartTime() {
        return whenScreened;
    }

    public boolean isSequence(int sequence) {
        return this.sequence == sequence;
    }

    public Money getMovieFee() {
        return movie.getFee();
    }

    /**
     * Movie의 calculateMovieFee 메서드를 호출한다. Movie의 caculateMovieFee 메서드의 반환 값은 1인당 예매 요금.
     * 따라서 Screening은 전체 요금을 구해가 위해 calculateMovieFee 메서드 반환 값에 인원 수인 audienceCount를 곱한다.
     */
    private Money calculateFee(int audienceCount) {
        return movie.calculateMovieFee(this).times(audienceCount);
    }
}
