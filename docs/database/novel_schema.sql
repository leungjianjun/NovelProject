-- 主机: localhost
-- 生成日期: 2012 年 09 月 13 日 07:23


SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- 数据库: `novel_schema`
--

-- --------------------------------------------------------

--
-- 表的结构 `chapter`
--

DROP TABLE IF EXISTS `chapter`;
CREATE TABLE IF NOT EXISTS `chapter` (
  `id` int(11) unsigned NOT NULL  AUTO_INCREMENT,
  `title` varchar(200) NOT NULL,
  `content` mediumtext NOT NULL,
  `update_time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `volume_id` int(11) unsigned NOT NULL,
  `chapter_status` int(11) unsigned  NOT NULL,
  PRIMARY KEY (`id`),
  KEY `volume_id` (`volume_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `volume`
--

DROP TABLE IF EXISTS `volume`;
CREATE TABLE IF NOT EXISTS `volume` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  `introduction` text NOT NULL,
  `create_time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `book_id` int(11) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `book_id` (`book_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `book`
--

DROP TABLE IF EXISTS `book`;
CREATE TABLE IF NOT EXISTS `book` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  `introduction` text NOT NULL,
  `book_status` int(11) unsigned NOT NULL DEFAULT '0',
  `create_time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `update_time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `category_id` int(11) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `category_id` (`category_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `nicename` varchar(50) NOT NULL,
  `account` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL DEFAULT '',
  `mobile` varchar(20),
  `create_time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `user_type` int(11) unsigned DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `account_key` (`account`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `author`
--

DROP TABLE IF EXISTS `author`;
CREATE TABLE IF NOT EXISTS `author` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(11) unsigned NOT NULL,
  `real_name` varchar(20) NOT NULL,
  `id_card` varchar(30) NOT NULL,
  `author_type` int(11) NOT NULL DEFAULT '0',
  `create_time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_id` (`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `category`
--

DROP TABLE IF EXISTS `category`;
CREATE TABLE IF NOT EXISTS `category` (
  `id` int(11) unsigned NOT NULL,
  `name` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;


-- --------------------------------------------------------

--
-- 表的结构 `tag`
--

DROP TABLE IF EXISTS `tag`;
CREATE TABLE IF NOT EXISTS `tag` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `tag_book`
--

DROP TABLE IF EXISTS `tag_book`;
CREATE TABLE IF NOT EXISTS `tag_book` (
  `tag_id` int(11) unsigned NOT NULL,
  `book_id` int(11) unsigned NOT NULL,
  PRIMARY KEY (`tag_id`,`book_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;


















--
-- 转存表中的数据 `author`
--


--
-- 转存表中的数据 `book`
--

INSERT INTO `book` (`id`, `name`, `introduction`, `book_status`, `create_time`, `update_time`, `category_id`) VALUES
(1, '蟑螂娘', '讲述了可爱的蟑螂娘一直试图与人类友善相处,经历了不少挫折困难,同时也遭到了同类无情唾弃的故事.', 0, '2012-09-26 00:00:00', '2012-09-26 00:00:00', 16777216);

--
-- 转存表中的数据 `category`
--

INSERT INTO `category` (`id`, `name`) VALUES
(16777216, '玄幻小说');

--
-- 转存表中的数据 `chapter`
--

INSERT INTO `chapter` (`id`, `title`, `content`, `update_time`, `volume_id`, `chapter_status`) VALUES
(1, '001 暴风雨来临前', '　因为就在这个时候，师傅得到了宗门下发的一颗“春秋丹”；春秋丹，顾名思义，服用者，可增加一年精纯功力！<p>　　是师父这次完成了宗门的任务，所获得的奖励。记得师父曾经说过，他再吃这种药也没有用处，所以，就想在自己师兄弟三人之中，选一个服用。</p><p>　　春秋丹，楚阳心中一阵悲哀，这种在上三天扔了都没有人拣的垃.圾货色，却成为大师兄陷害此次自己两人的理由！</p><p>　　记得前世，这颗春秋丹，仍是大师兄石千山得了去……</p><p>　　直到谈昙突然出了意外身死，自己有一次去拜祭谈昙的时候，却无意中看到大师兄也在，而且对着谈昙的墓碑，说出了这件事被自己偷听到，自己才知道，这位自己和谈昙一向尊敬的大师兄，竟然是如此卑劣的一个人！</p><p>　　想到这里，楚阳心中叹息。前世的自己和谈昙，是多么傻……</p><p>　　石千山，身材瘦削，看起来很精练，二十三四岁。平日里，对楚阳和谈昙都是极好，平时看来，这个大师兄，几乎比亲哥哥还要亲。</p><p>　　却没有想到，这一切竟然都是假的！他自始至终，都是在利用楚阳和谈昙！他平时的伪装，全为了在关键时候踩掉两人，独占师门的修炼资源！</p><p>　　石千山为何要这么做，楚阳也知道原因。他乃是千方百计，要进入天外楼内门，获得内门弟子资格。然后成为整个天外楼内门弟子的大师兄，进入天外楼七阴汇聚之地！</p><p>　　只要进入了那里，便是下一派宗主人选！天外楼历代弟子，只有一个人能进入！</p><p>　　石千山，对于权势，有狂热的追求热衷！在他眼中，为达目的，不惜牺牲一切！</p><p>　　楚阳三人，乃是天外楼之中的外围。按照常理来说，绝对没有可能进入内阁。石千山想要进入，必须在一次一次的宗门弟子大比之中脱颖而出，直到最后！</p><p>　　这也是天外楼历代以来激励弟子上进的手段。</p><p>　　所以这春秋丹，虽然仅仅能提升一年精纯功力，但对这些年轻弟子来说，一年的精纯功力，却足以将同级的师兄弟抛得远远地！</p><p>　　前一世，石千山成功了。他从现在的外围弟子的身份，一步步往上爬，最终终于是进入了内门，有了角逐大师兄之位的资格。</p><p>　　但就在四年后，天外楼不知什么原因，突然被各大门派联手围剿，一夜之间灰飞烟灭！</p><p>　　而楚阳重伤之下昏迷了过去，被重重尸体压在下面，等到醒来，已经是三天后。</p><p>　　当时天外楼到处烈火熊熊，还未燃烧完毕。天外楼的主楼，在三天剧烈地燃烧之后，终于完整的倒塌，险些将当时不能动弹的楚阳砸在下面。</p><p>　　但在倒塌之后，在地基深处，却露出了一截剑尖，闪闪发光！似乎带着魔鬼的诱惑……</p><p>　　那就是九劫剑第一截剑尖。</p><p>　　楚阳撞大运一般的得到了九劫剑剑尖，从此才开始了他的崛起之路……而那时候，他已经二十岁！</p><p>　　而那崩塌的地基，在楚阳记忆之中，就是天外楼七阴汇聚之地之所在！</p><p>　　石千山做梦也想进入的地方！</p><p>　　楚阳的嘴角露出了一丝笑容，喃喃的道：“这七阴汇聚之地，石千山，这一世，可是我的！”</p><p>　　既然重生，既然提前了四年，那么这四年怎能浪费？一定要提前得到九劫剑！而要得到九劫剑，就必须进入内门，获得大师兄资格，然后进入七阴之地！</p><p>　　除此之外，再也没有别的办法！</p><p>　　“你说什么？”楚阳的声音极低，谈昙根本没有听见，只是见他嘴唇嚅动了一下，不由问道。</p><p>　　“我说……这天真蓝！这地真厚！这紫竹真好看！这花真香！谈昙你长得真潇洒……哈哈哈哈……”楚阳一跃而起，突然放声大笑，笑声清越，远远传了出去。</p><p>　　这刹那，楚阳满心振奋！前世所有的遗憾，将在今世弥补！</p><p>　　轻舞，等我！</p><p>　　这一生，我不会让你失望！</p><p>　　我要让你知道，你比剑好看！我要让你知道，这个人世间，你最好看！你最好看！</p><p>　　谈昙，好兄弟！我不会再让你死！</p><p>　　莫天机，**给我等着！</p><p>　　天道巅峰，我楚阳……要、登！上！去！</p><p>　　“嘿，我长的潇洒这个是有的，可这天这地这紫竹……有啥好看的……真是神经。”谈昙翻了翻眼皮，一道眉毛像天上一耸，另一道眉毛往地下一戳，咕囔着道。</p><p>　　“楚阳，谈昙！你们在这里吗？”随着一阵爽朗的笑声，一个青衣青年从紫竹林之中闪身而出。</p><p>　　瘦削身材，削瘦的脸庞，微黑，一双眼睛不大，但却很有神。</p><p>　　石千山！</p><p>　　楚阳第一时间转过头去，平静的看着这张温和的笑脸，他分明清晰地看到，在石千山眼神深处，闪过一丝失望和懊恼。</p><p>　　这是看到楚阳竟然安然无恙而产生的懊恼！该死的，他怎么没死？</p><p>　　但随即石千山就露出一脸的怒容，喝道：“你们怎么搞的？楚阳，你的头上怎么回事？我不是早就告诉过你们，师兄弟之间切磋练功，点到为止点到为止！用这么大的力气，谈昙，你想把楚阳打死不成？”</p><p>　　谈昙有些畏惧的看着石千山，满脸惭愧，张了张嘴，呐呐的道：“大师兄，是……是我的错……我我的英俊潇洒震惊了楚阳，他……他愣神了……”</p><p>　　楚阳一阵无语。</p><p>　　“你们呀你们呀……真是不让我省心。”石千山恨铁不成钢的叹了口气：“啥时候才能让我和师父放心啊，这么大的人了还像个小孩子……”</p><p>　　说着快步走了过来，一脸的关切，在走动的过程中，已经“刺啦”一声，将自己内衣扯下来了一块，来到楚阳面前，一脸的怜惜：“疼么？别动，我给你包扎一下。别乱动，这几天别到处跑，免得伤口进了风……”</p><p>　　细心地用自己的衣襟给楚阳擦干了血迹，然后包扎了起来，用力轻柔，最后才放心的看了一遍，舒了口气，道：“唉，若是师父见到，定然又要怪我照顾不好两个师弟，你们俩呀……”一边叹息一边摇头。</p><p>　　“大师兄……我们错了……”谈昙难受的道：“对不起。我以后和他打，就蒙着脸好了……”</p><p>　　“你有啥对不起我的？唉，这么大的伤口，搁你身上你痛不痛？”石千山怒道：“你对不起的是楚阳师弟！”</p><p>　　对谈昙的自恋，石千山隐隐从眸子里露出一丝鄙夷。这样的丑八怪，居然能自恋到这地步？实在是匪夷所思。</p><p>　　石千山说话的时候，每一句话，让人听起来，都像是简直是从心底说出来的。而且眼神绝不退缩，直直注视着对方的眼睛，眼神坦荡，一看就知道胸怀磊落，所作的一切，都是出自真心！</p><p>　　“是，是。”谈昙连连点头，满脸的内疚惭愧。在大师兄满怀关切的责问之下，直觉得无地自容了。无奈的摸摸脸，哀怨的叹了一声，觉得自己这样的英俊潇洒，帅的这样惊天动地，实在是祸国殃民不可原谅的事情……</p><p>　　楚阳心中一阵叹息，这个石千山；无论是表情动作，还是口气，都是那样的真挚，毫无破绽。若自己不是重生回来，绝对会被他骗过去……</p><p>　　难怪此人在前世能够一直从外门弟子脱颖而出，一路青云直上，直到最后竞争大师兄的位置！</p><p>　　若是天外楼没有被灭，楚阳可以肯定，最后的内门大师兄位置，绝对是石千山的囊中之物！</p><p>　　这等当面一套背后一套的本事，实在是太难得了！简直是天衣无缝！别人永远不知道，他心中想的是什么。</p><p>　　难怪前世他能够在进入内门之后，在极短的时间里，就获得了宗主乌云凉之女乌倩倩的芳心……</p><p>　　乌倩倩号称是天外楼第一美女，追求的人何其多？但石千山貌不出众，却是不声不响的就虏获了这位天之骄女的芳心！当时这事一传出，整个天外楼都震惊了！</p><p>　　但现在楚阳却知道，这一切决不是偶然！石千山，他做得到！</p><p>　　不过这一世，石千山想要再轻易地做到……可就难了。因为，在他面前还有我楚阳！他的一切阴谋，在我面前，都形同虚设！</p><p>　　“走，跟我回去好好养伤。”石千山殷勤的扶起楚阳。</p><p>　　楚阳一笑，正要迈动脚步，突然一怔，从自己丹田之中，冒出来一股极度饥饿的感觉。或者说，是一种很迫切，很迫切的感觉。</p><p>　　楚阳顿时怔住！</p><p>　　这是怎么回事？肚子饿……也应该是肚子的事吧？或者是胃里难受，为啥丹田也饿了？</p><p>　　那种感觉潮水般涌来，丹田之中，也像是开了锅一般。</p><p>　　以楚阳的定力，竟然也是绝对无法忍受！楚阳实在忍不住，心神沉浸，运起功力内视过去，一看之下，楚阳险些惊呼出来！</p><p>　　在自己丹田的中间，竟然出现了一把虚无的小剑的影子！色泽黯淡，只有一个指头肚大小，剑身上，清晰可见有八条裂痕！</p><p>　　这把剑形状有些怪异，但对楚阳来说，却是无比的熟悉！</p><p>　　虽然残旧，但就只是这个虚幻的影子，也无形中翻出一丝吞天噬地的霸气！</p><p>　　这，这不是九劫剑么？！怎么会在自己的丹田中？</p><p>　　一时间，楚阳目瞪口呆，身子晃了两晃，差点震惊到摔倒！</p><p>　　&lt;推荐票有些少哇兄弟姐妹们，大家加把力吧。&gt;</p><p>　　', '2012-09-26 00:00:00', 1, 0);

--
-- 转存表中的数据 `tag`
--


--
-- 转存表中的数据 `tag_book`
--


--
-- 转存表中的数据 `user`
--


--
-- 转存表中的数据 `volume`
--

INSERT INTO `volume` (`id`, `name`, `introduction`, `create_time`, `book_id`) VALUES
(1, '第一卷', '哈哈哈哈哈哈哈哈哈哈哈哈啊哈哈哈哈斯蒂芬很多放大镜看获得世界返回假四大护法决定是否将设计阿飞的萨芬打开阿德类库设计', '2012-09-26 00:00:00', 1);

