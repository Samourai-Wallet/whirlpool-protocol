package com.samourai.whirlpool.protocol.v1.notifications;

public class RegisterInputRoundStatusNotification extends RoundStatusNotification {
    private long denomination;
    private long minerFee;

    public RegisterInputRoundStatusNotification() {

    }

    public RegisterInputRoundStatusNotification(String roundId) {
        super(RoundStatus.REGISTER_INPUT, roundId);
    }

    public long getDenomination() {
        return denomination;
    }

    public void setDenomination(long denomination) {
        this.denomination = denomination;
    }

    public long getMinerFee() {
        return minerFee;
    }

    public void setMinerFee(long minerFee) {
        this.minerFee = minerFee;
    }
}