/**
 * (C) Copyright 2010, 2011 upTick Pty Ltd
 *
 * Licensed under the terms of the GNU General Public License version 3
 * as published by the Free Software Foundation. You may obtain a copy of the
 * License at: http://www.gnu.org/copyleft/gpl.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package com.gwtcx.smartgwt.client.widgets;

import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.events.DrawEvent;
import com.smartgwt.client.widgets.events.DrawHandler;

public class TinyMceEditor extends Canvas {

  {
    setOverflow(Overflow.VISIBLE);
    setCanDragResize(false);
    setRedrawOnResize(false);
    setZIndex(0);
  }

  private boolean initialised = false;

  public TinyMceEditor(String id){
    super(id);

    addDrawHandler(new DrawHandler() {
      @Override
      public void onDraw(DrawEvent event) {
        configureTinyMceEditor();
        loadTinyMceEditor();
      }
    });

    /*

    addResizedHandler(new ResizedHandler() {
      @Override
      public void onResized(ResizedEvent event) {
        reSizeTinyMceEditor();
      }
    });

    */
  }

  @Override
  public String getInnerHTML() {

    if (this.getContents() != null) {
      return "<textarea style='width=100%;height=100%' id=" +
              this.getID() + "_ta>" +
              getContents()+ "</textarea>";
      }

    return "<textarea style='width=100%;height=100%' id=" + this.getID() + "_ta></textarea>";
  }

  protected native void configureTinyMceEditor() /*-{
    if (! this.@com.gwtcx.smartgwt.client.widgets.TinyMceEditor::initialised) {

        $wnd.tinyMCE.init({

                mode : "textareas",
                theme : "advanced",
                // plugins : "spellchecker",

                width:  "100%",
                height : "100%",

                theme_advanced_buttons1 : "cut,copy,paste,|,bold,italic,underline,|,justifyleft,justifycenter,justifyright,|,numlist,bullist,|,outdent,indent",
                theme_advanced_buttons2 : "",
                theme_advacned_buttons3 : "",
                theme_advacned_buttons4 : "",
                theme_advanced_toolbar_location : "top",
                theme_advanced_toolbar_align : "left",

                theme_advanced_statusbar : false,
                // theme_advanced_statusbar_location : "bottom",
                theme_advanced_path : false,

                theme_advanced_resizing : false,
                theme_advanced_resize_horizontal : false,
                theme_advanced_resizing_use_cookie : false,

                skin : "o2k7"


            });
    }
  }-*/;

  protected native void loadTinyMceEditor() /*-{
    if (! this.@com.gwtcx.smartgwt.client.widgets.TinyMceEditor::initialised) {
      var editorId = this.@com.gwtcx.smartgwt.client.widgets.TinyMceEditor::getID()() + "_ta";
      $wnd.tinyMCE.execCommand('mceAddControl', true, editorId);
      this.@com.gwtcx.smartgwt.client.widgets.TinyMceEditor::initialised = true;
    }
  }-*/;

  // newImage.setAttribute("style","width:100px;height:100px;");
  // $doc.getElementById(editorId + '_tbl').style.width='100%';

  protected native void reSizeTinyMceEditor() /*-{
    if (this.@com.gwtcx.smartgwt.client.widgets.TinyMceEditor::initialised) {
      var editorId = this.@com.gwtcx.smartgwt.client.widgets.TinyMceEditor::getID()() + "_ta";
      $doc.getElementById(editorId + '_tbl').setAttribute("style","width:100%;height:100%;");
    }
  }-*/;


  public boolean isLoaded() {
    return initialised;
  }
}

/*

        $wnd.tinyMCE.init({
                mode: "textareas",
                theme: "advanced",
                // plugins: "spellchecker",

                width: "100%",
                height: "100%",

                theme_advanced_buttons1: "cut,copy,paste,|,bold,italic,underline,|,justifyleft,justifycenter,justifyright,|,numlist,bullist,|,outdent,indent",
                theme_advanced_buttons2: "",
                theme_advacned_buttons3: "",
                theme_advacned_buttons4: "",
                theme_advanced_toolbar_location: "top",
                theme_advanced_toolbar_align: "left",

                theme_advanced_statusbar_location : 'bottom',
                theme_advanced_path : false,

                theme_advanced_resizing : false,
                theme_advanced_resize_horizontal : false,
                theme_advanced_resizing_use_cookie : false,

                skin: "o2k7"

            });


       mode : "textareas",
        theme : "advanced",
        plugins : "autolink,lists,spellchecker,pagebreak,style,layer,table,save,advhr,advimage,advlink,emotions,iespell,inlinepopups,insertdatetime,preview,media,searchreplace,print,contextmenu,paste,directionality,fullscreen,noneditable,visualchars,nonbreaking,xhtmlxtras,template",

        // Theme options
        theme_advanced_buttons1 : "save,newdocument,|,bold,italic,underline,strikethrough,|,justifyleft,justifycenter,justifyright,justifyfull,|,styleselect,formatselect,fontselect,fontsizeselect",
        theme_advanced_buttons2 : "cut,copy,paste,pastetext,pasteword,|,search,replace,|,bullist,numlist,|,outdent,indent,blockquote,|,undo,redo,|,link,unlink,anchor,image,cleanup,help,code,|,insertdate,inserttime,preview,|,forecolor,backcolor",
        theme_advanced_buttons3 : "tablecontrols,|,hr,removeformat,visualaid,|,sub,sup,|,charmap,emotions,iespell,media,advhr,|,print,|,ltr,rtl,|,fullscreen",
        theme_advanced_buttons4 : "insertlayer,moveforward,movebackward,absolute,|,styleprops,spellchecker,|,cite,abbr,acronym,del,ins,attribs,|,visualchars,nonbreaking,template,blockquote,pagebreak,|,insertfile,insertimage",
        theme_advanced_toolbar_location : "top",
        theme_advanced_toolbar_align : "left",
        theme_advanced_statusbar_location : "bottom",
        // theme_advanced_resizing : true,


                width: "100%",
                height: "100%",

        // Skin options
        skin : "o2k7",
        // skin_variant : "silver",

        // Example content CSS (should be your site CSS)
        content_css : "css/example.css",

        // Drop lists for link/image/media/template dialogs
        template_external_list_url : "js/template_list.js",
        external_link_list_url : "js/link_list.js",
        external_image_list_url : "js/image_list.js",
        media_external_list_url : "js/media_list.js",

        // Replace values for the template plugin
        template_replace_values : {
                username : "Some User",
                staffid : "991234"
        }




            TextArea ta = new TextArea();

            ta.removeStyleName("gwt-TextArea");
            ta.addStyleName(id);

            ta.getElement().setAttribute("id", id);
            ta.getElement().setAttribute("style", "width:100%");


http://stackoverflow.com/questions/1799123/how-to-automatic-resize-tinymce

The point is that TinyMCE generates an iframe in the place of the textarea, with this ID: originalID+"_ifr", and a table originalID+"_tbl" for holding the controls and the editor area.
To make fluid width:

document.getElementById(id+'_tbl').style.width='100%'


To make fluid height:

Change dinamically document.getElementById(id+'_tbl').style.width to the height you want, through JS.
This is the script I'm using for this:

function toScreenHeight(id, minus) {
    var height;

    if (typeof(window.innerHeight) == "number") //non-IE
        height = window.innerHeight;
    else if (document.documentElement && document.documentElement.clientHeight) //IE 6+ strict mode
        height = document.documentElement.clientHeight;
    else if (document.body && document.body.clientHeight) //IE 4 compatible / IE quirks mode
        height = document.body.clientHeight;

    document.getElementById(id).style.height = (height - minus) + "px";
}

You can use the code and function calls inside onload and onresize body events.

http://forums.smartclient.com/showthread.php?t=10147


*/
