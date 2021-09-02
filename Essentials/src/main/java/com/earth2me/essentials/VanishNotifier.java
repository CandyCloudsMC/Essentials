package com.earth2me.essentials;

import net.ess3.api.IEssentials;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;

import java.util.stream.StreamSupport;

import static com.earth2me.essentials.I18n.tl;

public class VanishNotifier implements Runnable {

    private final transient IEssentials ess;

    VanishNotifier(final IEssentials ess) {
        this.ess = ess;
    }

    @Override
    public void run() {
        StreamSupport.stream(this.ess.getOnlineUsers().spliterator(), false)
                .filter(User::isVanished)
                .forEach(U -> U.getBase().spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(tl("vanishActionBar"))));
    }
}
