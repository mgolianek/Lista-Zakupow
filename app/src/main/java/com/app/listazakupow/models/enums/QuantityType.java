package com.app.listazakupow.models.enums;

public enum QuantityType { //sztuka, kilogram, opakowanie etc
    SZT {
        @Override
        public String toString() {
            return "szt.";
        }
    },
    OP {
        @Override
        public String toString() {
            return "op.";
        }
    },
    KG {
        @Override
        public String toString() {
            return "kg";
        }
    },
    DAG {
        @Override
        public String toString() {
            return "dag";
        }
    },
    G {
        @Override
        public String toString() {
            return "g";
        }
    },
    L {
        @Override
        public String toString() {
            return "l";
        }
    },
    M {
        @Override
        public String toString() {
            return "m";
        }
    }
}
