package io.pello.homework.javahomeworkplatform;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by jt on 6/21/17.
 */
@Setter
@Getter
@NoArgsConstructor
public class MessageCommand {
    private Long id;
    private String title;
    private String content;
}