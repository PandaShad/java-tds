public class ToStringGeneric {

    StringBuilder sb;

    public String toString(Object object, int deep) {
        Class cl = object.getClass();

        sb.append(cl.getName()).append('[');
        if (c.isArray()) {
			String sep="{";
			for(int i = 0; i<Array.getLength(o); i++) {
				sb.append(sep);
				buildString(Array.get(o, i), profondeur-1);
				sep=", ";
			}
			sb.append("}");			
		} else {
			sb.append(c.getName()).append('[');
			String sep = "";
			Field[] fields = c.getDeclaredFields();
			for(Field field : fields) {  
				sb.append(sep);
				build(o, field, profondeur);
				sep = "; ";
			}

			fields = c.getFields();
			for(Field field : fields) { 
				if (field.getDeclaringClass()==c) continue; 
				sb.append(sep);
				build(o, field, profondeur);
				sep = "; ";
			}
			sb.append(']');
		}
	}

	private void build(Object o, Field field, int profondeur) {
		sb.append(field.getName()).append('='); 
		field.setAccessible(true);
		try {
			Object fieldVal = field.get(o);
			Class<?> type = field.getType();
			if(type.isPrimitive()) sb.append(fieldVal);
			else if (type == String.class) sb.append('"').append(fieldVal).append('"');
			else buildString(fieldVal, profondeur-1);
		} catch (Exception e) {
			sb.append("NO_ACCESS");
		}
	}

	static public void main(String[] args) {
	}
}
