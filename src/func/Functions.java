package func;


public class Functions extends Function {
    public double value;
    public Function[] functions = new Function[]{new Function() {
        @Override
        public Double call() throws Exception {
            return Math.sin(value);
        }

        @Override
        public String toString() {
            return "sin()";
        }

        @Override
        public String formatOutput() {
            return "sin(%s)";
        }
    }, new Function() {
        @Override
        public Double call() throws Exception {
            return Math.cos(value);
        }

        @Override
        public String toString() {
            return "cos()";
        }

        @Override
        public String formatOutput() {
            return "cos(%s)";
        }
    }, new Function() {
        @Override
        public Double call() throws Exception {
            return Math.tan(value);
        }

        @Override
        public String toString() {
            return "tg()";
        }

        @Override
        public String formatOutput() {
            return "tg(%s)";
        }
    }, new Function() {
        @Override
        public Double call() throws Exception {
            return 1 / Math.tan(value);
        }

        @Override
        public String toString() {
            return "ctg()";
        }
        @Override
        public String formatOutput() {
            return "ctg(%s)";
        }
    }, new Function() {
        @Override
        public Double call() throws Exception {
            return Math.log(value);
        }

        @Override
        public String toString() {
            return "loge()";
        }
        @Override
        public String formatOutput() {
            return "loge(%s)";
        }
    },
            new Function() {
                @Override
                public Double submit() throws Exception {
                    return Math.acos(value);
                }

                @Override
                public String toString() {
                    return "acos()";
                }
                @Override
                public String formatOutput() {
                    return "acos(%s)";
                }
            },
            new Function() {
                @Override
                public Double submit() throws Exception {
                    return Math.asin(value);
                }

                @Override
                public String toString() {
                    return "asin()";
                }
                @Override
                public String formatOutput() {
                    return "asin(%s)";
                }
            },
            new Function() {
                @Override
                public Double submit() throws Exception {
                    return Math.cbrt(value);
                }

                @Override
                public String toString() {
                    return "cbrt()";
                }

                @Override
                public String formatOutput() {
                    return "cbrt(%s)";
                }
            },
            new Function() {
                @Override
                public Double submit() throws Exception {
                    return Math.cosh(value);
                }

                @Override
                public String toString() {
                    return "cosh()";
                }
                @Override
                public String formatOutput() {
                    return "cosh(%s)";
                }
            }};

    public Function getFunctionAtIndex(int i) {
        return functions[i];
    }

    public String getFunctionNameAtIndex(int i) {
        return functions[i].toString();
    }

    public Double getValueFromFunction(int i, double value) throws Exception {
        this.value = value;
        return functions[i].submit();
    }

    public int getLength() {
        return functions.length;
    }

    public String getFunctionFormattedNameAtIndex(int i) {
        return functions[i].formatOutput();
    }

}
