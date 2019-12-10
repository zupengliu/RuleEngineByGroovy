package com.dymic

class ContextVo {

    private Long amount

    private String nextScenario

    Long getAmount() {
        return amount
    }

    void setAmount(Long amount) {
        this.amount = amount
    }

    String getNextScenario() {
        return nextScenario
    }

    void setNextScenario(String nextScenario) {
        this.nextScenario = nextScenario
    }

    static void main(String[] args) {
        ContextVo contextVo = new ContextVo()
        contextVo.setAmount(3000L)
        print("amount="+contextVo.amount)
    }
}
