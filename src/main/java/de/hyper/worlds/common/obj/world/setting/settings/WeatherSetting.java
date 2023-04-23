package de.hyper.worlds.common.obj.world.setting.settings;

import de.hyper.worlds.common.enums.SettingType;
import de.hyper.worlds.common.obj.world.setting.SettingState;
import de.hyper.worlds.common.obj.world.setting.WorldSetting;
import org.bukkit.Material;

public class WeatherSetting extends WorldSetting {

    public WeatherSetting() {
        super(SettingType.WEATHER,
                new SettingState(
                        b("weather.sun","sun"),
                        b("weather.rain","rain"),
                        b("weather.storm","storm"),
                        b("weather.running","running")),
                "Weather", "settings.weather.desc", Material.SNOW_BALL, false);
    }
}