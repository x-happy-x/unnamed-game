package ru.legilimens.game.resources;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public final class Resource {
    private String name;
    private String path;
    private String type;
    private boolean preload;
}
