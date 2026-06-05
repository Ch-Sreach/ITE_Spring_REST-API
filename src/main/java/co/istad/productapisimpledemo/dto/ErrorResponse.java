package co.istad.productapisimpledemo.dto;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
// use error jea generic cause ot dg tha error bos yg jea type ey
public record ErrorResponse<T>(
        LocalDateTime timestamp,
        String message,
        T errors,
        Integer status
) {
}
