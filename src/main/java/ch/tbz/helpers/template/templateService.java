package ch.tbz.helpers.template;

import com.google.common.collect.Maps;
import com.hubspot.jinjava.Jinjava;

import java.util.Map;

public class templateService {
    public static void main(String[] args)  {

        var jnj = new Jinjava();

        Map<String, Object> context = Maps.newHashMap();
        context.put("name", "John Doe");

        String res = jnj.render("Hello {{ name }}!", context);
        System.out.println(res);
    }
}
