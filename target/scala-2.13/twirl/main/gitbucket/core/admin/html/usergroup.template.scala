
package gitbucket.core.admin.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object usergroup extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[Option[gitbucket.core.model.Account],List[gitbucket.core.model.GroupMember],gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(account: Option[gitbucket.core.model.Account], members: List[gitbucket.core.model.GroupMember])(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*2.2*/import gitbucket.core.view.helpers


Seq[Any](_display_(/*3.2*/gitbucket/*3.11*/.core.html.main(if(account.isEmpty) "New group" else "Update group")/*3.79*/{_display_(Seq[Any](format.raw/*3.80*/("""
  """),_display_(/*4.4*/gitbucket/*4.13*/.core.admin.html.menu("users")/*4.43*/{_display_(Seq[Any](format.raw/*4.44*/("""
    """),format.raw/*5.5*/("""<form id="form" method="post" action=""""),_display_(/*5.44*/context/*5.51*/.path),format.raw/*5.56*/("""/admin/users/"""),_display_(/*5.70*/(account.map(x => s"${x.userName}/_editgroup").getOrElse("_newgroup"))),format.raw/*5.140*/("""" validate="true" autocomplete="off">
      """),_display_(/*6.8*/gitbucket/*6.17*/.core.account.html.groupform(account, members, true)),format.raw/*6.69*/("""
      """),format.raw/*7.7*/("""<fieldset class="border-top">
        """),_display_(if(account.isDefined)/*8.31*/{_display_(Seq[Any](format.raw/*8.32*/("""
          """),format.raw/*9.11*/("""<div class="pull-right">
            <a href=""""),_display_(/*10.23*/helpers/*10.30*/.url(account.get.userName)),format.raw/*10.56*/("""/_deletegroup" id="delete" class="btn btn-danger">Delete group</a>
          </div>
        """)))} else {null} ),format.raw/*12.10*/("""
        """),format.raw/*13.9*/("""<input type="submit" class="btn btn-success" value=""""),_display_(if(account.isEmpty)/*13.81*/{_display_(Seq[Any](format.raw/*13.82*/("""Create group""")))}else/*13.101*/{_display_(Seq[Any](format.raw/*13.102*/("""Update group""")))}),format.raw/*13.115*/(""""/>
        <a href=""""),_display_(/*14.19*/context/*14.26*/.path),format.raw/*14.31*/("""/admin/users" class="btn btn-default">Cancel</a>
      </fieldset>
    </form>
  """)))}),format.raw/*17.4*/("""
""")))}),format.raw/*18.2*/("""
"""))
      }
    }
  }

  def render(account:Option[gitbucket.core.model.Account],members:List[gitbucket.core.model.GroupMember],context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(account,members)(context)

  def f:((Option[gitbucket.core.model.Account],List[gitbucket.core.model.GroupMember]) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (account,members) => (context) => apply(account,members)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/admin/usergroup.scala.html
                  HASH: 6ec10809e4b4007fba7009cbb5a1ff77398397c1
                  MATRIX: 688->1|910->152|973->188|990->197|1066->265|1104->266|1133->270|1150->279|1188->309|1226->310|1257->315|1322->354|1337->361|1362->366|1402->380|1493->450|1563->495|1580->504|1652->556|1685->563|1771->623|1809->624|1847->635|1921->682|1937->689|1984->715|2121->808|2157->817|2256->889|2295->890|2332->909|2372->910|2417->923|2466->945|2482->952|2508->957|2620->1039|2652->1041
                  LINES: 14->1|17->2|20->3|20->3|20->3|20->3|21->4|21->4|21->4|21->4|22->5|22->5|22->5|22->5|22->5|22->5|23->6|23->6|23->6|24->7|25->8|25->8|26->9|27->10|27->10|27->10|29->12|30->13|30->13|30->13|30->13|30->13|30->13|31->14|31->14|31->14|34->17|35->18
                  -- GENERATED --
              */
          