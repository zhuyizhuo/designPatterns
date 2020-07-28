package com.zhuo.designpatterns.behavioral.command;

import com.zhuo.designpatterns.behavioral.command.command.impl.InCommand;
import com.zhuo.designpatterns.behavioral.command.command.impl.OutCommand;

/**
 命令模式

 耦合与变化：耦合是软件不能抵御变化灾难的根本性原因。不仅实体对象与实体对象之间存在耦合关系，实体对象与行为操作之间也存在耦合关系。

 动机(Motivate):
	 在软件系统中，“行为请求者”与“行为实现者”通常呈现一种“紧耦合”。但在某些场合，比如要对行为进行“记录、撤销/重做、事务”等处理，
	 这种无法抵御变化的紧耦合是不合适的。 在这种情况下，如何将“行为请求者”与“行为实现者”解耦？将一组行为抽象为对象，可以实现二者之间的松耦合。

 意图(Intent):
 	将一个请求封装为一个对象，从而使你可用不同的请求对客户进行参数化；对请求排队或记录请求日志，以及支持可撤消的操作。
																				-------《设计模式》GOF
 适用性：
	 1．使用命令模式作为"CallBack"在面向对象系统中的替代。"CallBack"讲的便是先将一个函数登记上，然后在以后调用此函数。
	 2．需要在不同的时间指定请求、将请求排队。
		一个命令对象和原先的请求发出者可以有不同的生命期。换言之，原先的请求发出者可能已经不在了，而命令对象本身仍然是活动的。
		这时命令的接收者可以是在本地，也可以在网络的另外一个地址。命令对象可以在串形化之后传送到另外一台机器上去。
	 3．系统需要支持命令的撤消(undo)。命令对象可以把状态存储起来，
		等到客户端需要撤销命令所产生的效果时，可以调用undo()方法，把命令所产生的效果撤销掉。
		命令对象还可以提供redo()方法，以供客户端在需要时，再重新实施命令效果。
	 4．如果一个系统要将系统中所有的数据更新到日志里，以便在系统崩溃时，可以根据日志里读回所有的数据更新命令，
		重新调用Execute()方法一条一条执行这些命令，从而恢复系统在崩溃前所做的数据更新。

 Command实现要点：
	 1．Command模式的根本目的在于将“行为请求者”与“行为实现者”解耦，在面向对象语言中，常见的实现手段是“将行为抽象为对象”。
	 2．实现Command接口的具体命令对象ConcreteCommand有时候根据需要可能会保存一些额外的状态信息。
	 3．通过使用Composite模式，可以将多个命令封装为一个“复合命令”MacroCommand。
	 4．Command模式与C#中的Delegate有些类似
	 。但两者定义行为接口的规范有所区别：Command以面向对象中的“接口-实现”来定义行为接口规范，更严格
	 ，更符合抽象原则；Delegate以函数签名来定义行为接口规范，更灵活，但抽象能力比较弱。
	 5．使用命令模式会导致某些系统有过多的具体命令类。某些系统可能需要几十个，几百个甚至几千个具体命令类，这会使命令模式在这样的系统里变得不实际。

 总结
	 对于一个场合到底用不用模式，这对所有的开发人员来说都是一个很纠结的问题。有时候，因为预见到需求上会发生的某些变化，
	 为了系统的灵活性和可扩展性而使用了某种设计模式，但这个预见的需求偏偏没有，
	 相反，没预见到的需求倒是来了不少，导致在修改代码的时候，使用的设计模式反而起了相反的作用，以至于整个项目组怨声载道。这样的例子，
	 我相信每个程序设计者都遇到过。所以，基于敏捷开发的原则，我们在设计程序的时候，如果按照目前的需求，不使用某种模式也能很好地解决，
	 那么我们就不要引入它，因为要引入一种设计模式并不困难，我们大可以在真正需要用到的时候再对系统进行一下，引入这个设计模式。
	 拿命令模式来说吧，我们开发中，请求-响应模式的功能非常常见，一般来说，我们会把对请求的响应操作封装到一个方法中，
	 这个封装的方法可以称之为命令，但不是命令模式。到底要不要把这种设计上升到模式的高度就要另行考虑了，
	 因为，如果使用命令模式，就要引入调用者、接收者两个角色，原本放在一处的逻辑分散到了三个类中，设计时，必须考虑这样的代价是否值得。

 @author zhuo
 * 
 */
//具体命令的调用

public class TestCommand {
	public static void main(String[] args) {
		OutCommand out = new OutCommand();
		InCommand in = new InCommand();
		ExecuteCommand command = new ExecuteCommand(out,in);
		command.execIn();
		command.execOut();
	}
}