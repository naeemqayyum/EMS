package com.employee;

class Burger {
    private String bun;
    private String patty;
    private boolean cheese;
    private boolean lettuce;

    // Private constructor
    private Burger(Builder builder) {
        this.bun = builder.bun;
        this.patty = builder.patty;
        this.cheese = builder.cheese;
        this.lettuce = builder.lettuce;
    }

    public static class Builder {
        private String bun;
        private String patty;
        private boolean cheese;
        private boolean lettuce;

        public Builder bun(String bun) {
            this.bun = bun;
            return this;
        }

        public Builder patty(String patty) {
            this.patty = patty;
            return this;
        }

        public Builder cheese(boolean value) {
            this.cheese = value;
            return this;
        }

        public Builder lettuce(boolean value) {
            this.lettuce = value;
            return this;
        }

        public Burger build() {
            return new Burger(this);
        }
    }


}



