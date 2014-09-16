package neverfate_bot;

import java.util.Vector;

public class Maps {
	public static class Catacomb_node {
		public Catacomb_node(String direct, String action) {
			this.direct = Integer.parseInt(direct);
			this.action = Integer.parseInt(action);
		}
		int direct;//0-north 1-east 2-south 3-west
		int action;//0-nothing 1-mob 2-key 3-chest 4-move 
	}
	
	
	public static Vector<Catacomb_node> get_catacomb_map() {
		Vector<String> line = Data.read_data("./data/catacomb_map");
		Vector<Catacomb_node> map = new Vector<Catacomb_node>();
		for(String lin : line) {
			if(lin.length() > 1) {
				Catacomb_node node = new Catacomb_node(lin.substring(0, 1), lin.substring(1, 2));
				map.add(node);
			}
			
		}
		return map;
	}

    public static Vector<Integer> get_drem_map() {
        Vector<String> lines = Data.read_data("./data/drem_map");
        Vector<Integer> map = new Vector<Integer>();
        for(String line : lines) {
            if(line.length() > 0) {
                map.add(Integer.parseInt(line));
            }
        }
        return map;
    }
	
	

}
