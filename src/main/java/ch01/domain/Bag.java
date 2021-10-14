package ch01.domain;

/**
 * 이벤트 당첨자는 티켓을 교환할 초대장을 있을 것.
 * 일반 관람객은 티켓을 살 돈을 가지고 있을 것.
 * 따라서 관람객이 가지고 올 수 있는 소지품은 초대장, 현금, 티켓 세 가지 뿐임.
 * 이때 관람객은 가방에 이것들을 보관한다고 가정.
 */
public class Bag {
    private Long amount;
    private Invitation invitation;
    private Ticket ticket;

    /**
     * 이벤트에 당첨된 관람객 가방 안에는 현금과 초대장이 들어있지만 당첨되지 않은 관람객 가방 안에는 초대장이 들어있지 않을 것.
     * 따라서 ch01.domain.Bag 인스턴스 상태는 현금과 초대장을 함께 보관하거나 초대장 없이 현금만 보관하는 형태 두 가지 중 하나일 것이므로
     * ch01.domain.Bag 인스턴스 생성 시점에 이 제약을 강제하도록 생성자 정의.
     */
    public Bag(long amount) {
        this(null, amount);
    }

    public Bag(Invitation invitation, long amount) {
        this.invitation = invitation;
        this.amount = amount;
    }

    public boolean hasInvitation() {
        return invitation != null;
    }

    public boolean hasTicket() {
        return ticket != null;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public void minusAmount(Long amount) {
        this.amount -= amount;
    }

    public void plusAmount(Long amount) {
        this.amount += amount;
    }
}
