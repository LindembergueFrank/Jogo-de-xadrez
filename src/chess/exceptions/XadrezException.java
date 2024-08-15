package chess.exceptions;

import java.io.Serial;

public class XadrezException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public XadrezException(String mensagem) {
        super(mensagem);
    }
}
