package fi.iki.jka;

import org.junit.Test;

import java.awt.event.ActionEvent;

public class JPhotoFrameTest {
    @Test
    //If photos, then create show and call show.setvisible
    public void ifPhotosCreateShowAndCallSetVisible() throws Exception {
        JPhotoCollection collection = new JPhotoCollection(new String[]{"hello", "world"});
        JPhotoFrame underTest = new JPhotoFrame("",collection);
        underTest.setSlideShowVisible();
        assert (underTest.show.isVisible());
    }

    @Test
    public void actionPerformedIfPhotosCreateShowAndCallSetVisible() throws Exception {
        JPhotoCollection collection = new JPhotoCollection(new String[]{"hello", "world"});
        JPhotoFrame underTest = new JPhotoFrame("",collection);
        underTest.actionPerformed(new ActionEvent(new Object(), 0, JPhotoMenu.A_SLIDESHOW));
        assert (underTest.show.isVisible());
    }

    @Test
    public void actionPerformedIfPhotosCreateShowWithCorrectDefaultInterval() throws Exception {
        JPhotoCollection collection = new JPhotoCollection(new String[]{"hello", "world"});
        JPhotoFrame underTest = new JPhotoFrame("",collection);
        underTest.actionPerformed(new ActionEvent(new Object(), 0, JPhotoMenu.A_SLIDESHOW));
        assert (underTest.show.timer.getDelay() == 5000);
    }

    @Test
    public void actionPerformedIfPhotosCreateFastShowCorrectCustomInterval() throws Exception {
        JPhotoCollection collection = new JPhotoCollection(new String[]{"hello", "world"});
        JPhotoFrame underTest = new JPhotoFrame("",collection);
        underTest.actionPerformed(new ActionEvent(new Object(), 0, JPhotoMenu.A_FASTER_SLIDESHOW));
        assert (underTest.show.timer.getDelay() == 1000);
    }

    @Test
    public void ifNoPhotosDoesNotCallSetVisible() throws Exception {
        JPhotoCollection collection = new JPhotoCollection(new String[]{});
        JPhotoFrame underTest = new JPhotoFrame("",collection);
        underTest.setSlideShowVisible();
        assert (underTest.show == null);
    }
}