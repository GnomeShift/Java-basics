public interface TextProcessor {
    public String processText(String text);
}

class BaseTextProcessor implements TextProcessor {
    @Override
    public String processText(String text) {
        return text;
    }
}

class UppercaseTextProcessor implements TextProcessor {
    private TextProcessor processor;

    public UppercaseTextProcessor(TextProcessor processor) {
        this.processor = processor;
    }

    @Override
    public String processText(String text) {
        return processor.processText(text).toUpperCase();
    }
}

class TrimTextProcessor implements TextProcessor {
    private TextProcessor processor;

    public TrimTextProcessor(TextProcessor processor) {
        this.processor = processor;
    }

    @Override
    public String processText(String text) {
        return processor.processText(text).trim();
    }
}

class ReplaceTextProcessor implements TextProcessor {
    private TextProcessor processor;

    public ReplaceTextProcessor(TextProcessor processor) {
        this.processor = processor;
    }

    @Override
    public String processText(String text) {
        return processor.processText(text).replace(" ", "_");
    }

    public static void main(String[] args) {
        TextProcessor processor = new BaseTextProcessor();

        processor = new UppercaseTextProcessor(processor);
        processor = new TrimTextProcessor(processor);
        processor = new ReplaceTextProcessor(processor);

        String text = " Декорируем эту строку";

        System.out.println(processor.processText(text));
    }
}
