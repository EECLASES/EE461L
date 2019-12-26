package assignment7;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;

public class ReactIcon {

//	public enum IconString {
//        HEART,
//        LAUGH,
//        DISLIKE,
//        LIKE,
//        SAD
//    }
//	public IconString icon;
	private FontAwesomeIconView pictureIcon;
	
	 
	
	public ReactIcon(String name) {
		pictureIcon = getNewIcon(name);
		 
	}
	
	
	public FontAwesomeIconView getPictureIcon() {
		return pictureIcon;
	}


	public void setPictureIcon(FontAwesomeIconView pictureIcon) {
		this.pictureIcon = pictureIcon;
	}


	public FontAwesomeIconView getNewIcon(String icon) {
		switch(icon)
		{
		case "HEART":
			FontAwesomeIconView heart = new FontAwesomeIconView(FontAwesomeIcon.HEART);
		    return heart;
		case "LAUGH":
			FontAwesomeIconView laugh = new FontAwesomeIconView(FontAwesomeIcon.SMILE_ALT);
		    return laugh;
		case "DISLIKE":
			 FontAwesomeIconView dislike = new FontAwesomeIconView(FontAwesomeIcon.THUMBS_DOWN);
			 return dislike;
		case "LIKE":
			 FontAwesomeIconView like = new FontAwesomeIconView(FontAwesomeIcon.THUMBS_UP);
			 return like;
		case "SAD":
			 FontAwesomeIconView sad = new FontAwesomeIconView(FontAwesomeIcon.FROWN_ALT);
			 return sad;
		}
		return null;
	}
}
